//
//  HttpRequest.h
//  HttpRequestManager
//
//  Created by Vaith on 16/7/22.
//  Copyright © 2016年 Vaith. All rights reserved.
//

#import <Realm/Realm.h>
#import "HttpRequestManager.h"

@interface HttpRequest : RLMObject
@property HttpRequestMethod method;
@property HttpRequestMode mode;
@property HttpRequestServer server;
@property NSString *key;
@property NSString *pathString;
@property NSData *params;
@property NSData *data;
@property NSDate *time;
- (id)toJson;
@end
