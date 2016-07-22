//
//  HttpRequest.m
//  HttpRequestManager
//
//  Created by Vaith on 16/7/22.
//  Copyright © 2016年 Vaith. All rights reserved.
//

#import "HttpRequest.h"

@implementation HttpRequest
- (id)toJson
{
    NSDictionary *dictionary = [NSJSONSerialization JSONObjectWithData:self.data options:NSJSONReadingMutableContainers error:nil];
    return dictionary;
}
@end
