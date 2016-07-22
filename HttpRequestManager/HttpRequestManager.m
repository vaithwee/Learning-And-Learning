//
//  HttpRequestManager.m
//  HttpRequestManager
//
//  Created by Vaith on 16/7/22.
//  Copyright © 2016年 Vaith. All rights reserved.
//

#import "HttpRequestManager.h"
#import <AFNetworking/AFNetworking.h>
#import <Realm/Realm.h>
#import "HttpRequest.h"

@implementation HttpRequestManager

+ (void)httpRequestWithMethod:(HttpRequestMethod)method server:(HttpRequestServer)server mode:(HttpRequestMode)mode pathString:(NSString *)pathString params:(NSDictionary *)params cache:(HttpCacheType)cache success:(void(^)(BOOL isCache, id data))success failure:(void(^)(NSError *error))failure isLoaind:(BOOL)isLoading
{
    /*获取完整URL路径*/
    NSString *urlString = [[self getServerAddress:server] stringByAppendingPathComponent:[self getModeName:mode]];
    
    /*设置路径*/
    if (pathString)
    {
        urlString = [urlString stringByAppendingPathComponent:pathString];
    }
    
    urlString = [urlString stringByReplacingOccurrencesOfString:@"//" withString:@"/"];

    if (HttpRequestServerDefault == server)
    {

    }
    
    
    /*缓存查询*/
    NSPredicate *pred = [NSPredicate predicateWithFormat:@"key = %@ AND mode = %d AND server = %d AND method = %d", params[@"method"]?:pathString, mode, server, method];
    RLMResults<HttpRequest *> *result = [HttpRequest objectsWithPredicate:pred];
    HttpRequest *request;
    if (result.count > 0 && HttpCacheTypeOnlyNew != cache)
    {
        request = [result lastObject];
        success(YES, [request toJson]);
        if (HttpCacheTypeUseCache == cache)
        {
            return;
        }
    }
    
    
    /*获取请求器*/
    AFHTTPSessionManager *session = [AFHTTPSessionManager manager];
    
    /*设置请求数据和回调*/
    if (HttpRequestMethodPost == method) {
        [session POST:urlString parameters:params progress:^(NSProgress * _Nonnull uploadProgress) {
            
        } success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
            success(NO, responseObject);
            [self operateCache:request server:server mode:mode method:method pathString:pathString params:params data:responseObject];
        } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
            failure(error);
        }];
    }
    else if (HttpRequestMethodGet == method)
    {
        [session GET:urlString parameters:params progress:^(NSProgress * _Nonnull downloadProgress) {
            
        } success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
            success(NO, responseObject);
            [self operateCache:request server:server mode:mode method:method pathString:pathString params:params data:responseObject];
        } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
            failure(error);
        }];
    }
}

#pragma mark 缓存处理
+ (void)operateCache:(HttpRequest *)request server:(HttpRequestServer)server mode:(HttpRequestMode)mode method:(HttpRequestMethod)method pathString:(NSString *)pathString params:(NSDictionary *)params data:(id)data
{
    RLMRealm *realm = [RLMRealm defaultRealm];
    if (request)
    {
        /*缓存更新*/
        [realm beginWriteTransaction];
        request.server = server;
        request.mode = mode;
        request.method = method;
        request.pathString = pathString;
        request.params = params?[NSJSONSerialization dataWithJSONObject:params options:NSJSONWritingPrettyPrinted error:nil]:nil;
        request.key = params[@"method"]?:pathString;
        request.data = [NSJSONSerialization dataWithJSONObject:data options:NSJSONWritingPrettyPrinted error:nil];
        request.time = [NSDate dateWithTimeIntervalSinceNow:0];
        [realm commitWriteTransaction];
    }
    else
    {
        /*创建缓存*/
        request = [HttpRequest new];
        request.server = server;
        request.mode = mode;
        request.method = method;
        request.pathString = pathString;
        request.params = params?[NSJSONSerialization dataWithJSONObject:params options:NSJSONWritingPrettyPrinted error:nil]:nil;
        request.key = params[@"method"]?:pathString;
        request.data = [NSJSONSerialization dataWithJSONObject:data options:NSJSONWritingPrettyPrinted error:nil];
        request.time = [NSDate dateWithTimeIntervalSinceNow:0];
        [realm transactionWithBlock:^{
            [realm addObject:request];
        }];
    }

}

#pragma mark 获取模块名称
+ (NSString *)getModeName:(HttpRequestMode)mode
{
    NSString *modeName;
    switch (mode)
    {
        case HttpRequestModeLogin:
            modeName = @"login.sp";
            break;
            
        case HttpRequestModeTicket:
            modeName = @"v1/tickets";
            break;
        default:
            break;
    }
    return modeName;
}

#pragma mark 获取服务器地址
+ (NSString *)getServerAddress:(HttpRequestServer)server
{
    NSString *url;
    switch (server)
    {

        case HttpRequestServerUser:
        {
            url = @"http://cas.sq84.com:91";
            break;
        }
        case HttpRequestServerVaith:
        {
            url = @"http://www.vaith.xyz";
            break;
        }
        case HttpRequestServerDefault:
        default:
        {
            url = @"http://120.55.246.127/app";
            break;
        }
    }

    return url;
}

#pragma mark 获取UUID
+ (NSString *)UUID
{
   return [[UIDevice currentDevice].identifierForVendor UUIDString];
}
@end
