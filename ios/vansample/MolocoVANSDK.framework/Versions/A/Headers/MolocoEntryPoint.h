//
//  MolocoEntryPoint.h
//  vansdk
//
//  Created by 김 균태 on 2015. 7. 21..
//  Copyright (c) 2015년 Moloco. All rights reserved.
//

#import <Foundation/Foundation.h>

#ifndef vansdk_MolocoEntryPoint_h
#define vansdk_MolocoEntryPoint_h

@protocol MolocoApiCallback <NSObject>

- (void)handleResponse:(NSDictionary *)response;

@end

@interface MolocoEntryPoint : NSObject<NSURLConnectionDelegate>
{
	NSMutableData *_responseData;
}

- (void)setAppName:(NSString *)appName;
+ (id)sharedInstance;
+ (void)sendEvent:(NSString *)eventName dataMap:(NSDictionary *)dataMap delegate:(id<MolocoApiCallback>)delegate;
+ (void)getEvent:(NSString *)eventName delegate:(id<MolocoApiCallback>)delegate;

@property (nonatomic, weak) id<MolocoApiCallback> delegate;

@end

#endif