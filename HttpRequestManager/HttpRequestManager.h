//
//  HttpRequestManager.h
//  HttpRequestManager
//
//  Created by Vaith on 16/7/22.
//  Copyright © 2016年 Vaith. All rights reserved.
//

#import <Foundation/Foundation.h>

extern const NSString *baseUrl;

typedef NS_ENUM(NSInteger, HttpRequestMethod) {
    HttpRequestMethodGet = 0,
    HttpRequestMethodPost,
    HttpRequestMethodPut,
    HttpRequestMethodDelete
};

typedef NS_ENUM(NSInteger, HttpRequestServer)
{
    HttpRequestServerDefault = 0,
    HttpRequestServerUser,
    HttpRequestServerVaith,
    
};

typedef NS_ENUM(NSInteger, HttpRequestMode) {
    HttpRequestModeLogin = 0,
    HttpRequestModeTicket,
};

typedef NS_ENUM(NSInteger, HttpCacheType) {
    HttpCacheTypeUseCacheAndUpdateCache,
    HttpCacheTypeUseCache,
    HttpCacheTypeOnlyNew,
    
};

@interface HttpRequestManager : NSObject

+ (void)httpRequestWithMethod:(HttpRequestMethod)method
                       server:(HttpRequestServer)server
                         mode:(HttpRequestMode)mode
                   pathString:(NSString *)pathString
                       params:(NSDictionary *)params
                        cache:(HttpCacheType)cache
                      success:(void(^)(BOOL isCache, id data))success
                      failure:(void(^)(NSError *error))failure
                     isLoaind:(BOOL)isLoading;
@end
