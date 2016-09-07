#import <Foundation/Foundation.h>

#ifndef VAN_SDK_MolocoEntryPoint_h
#define VAN_SDK_MolocoEntryPoint_h

@protocol MolocoApiCallback <NSObject>

- (void)handleVANResponse:(NSString *)response;

@end

@interface MolocoEntryPoint : NSObject<NSURLConnectionDelegate>
{
    NSMutableData *_responseData;
    NSString *appName;
}

+ (id)sharedInstance;
+ (void)setAppName:(NSString *)appName;
+ (void)sendEvent:(NSString *)eventName dataMap:(NSDictionary *)dataMap delegate:(id<MolocoApiCallback>)delegate;

@property (nonatomic, weak) id<MolocoApiCallback> delegate;
@property (nonatomic, retain) NSString *appName;

@end

#endif
