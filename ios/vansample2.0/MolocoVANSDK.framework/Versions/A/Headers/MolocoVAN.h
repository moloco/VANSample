#import <Foundation/Foundation.h>
#import <AdSupport/ASIdentifierManager.h>
#import <UIKit/UIKit.h>
#import "Constants.h"

#ifndef VAN_SDK_MolocoEntryPoint_h
#define VAN_SDK_MolocoEntryPoint_h

@protocol MolocoApiCallback <NSObject>

- (void)onSuccessResponse:(NSString *)response;
- (void)onFailureResponse:(NSString *)response;

@end

@interface MolocoVAN : NSObject<NSURLConnectionDelegate>
{
    NSMutableData *_responseData;
    NSString *productId;
    NSString *apiKey;
}

+ (id)sharedInstance;

+ (void)setProductId:(NSString *)productId
              apiKey:(NSString *)apiKey;

+ (void)sendEvent:(EventType)eventType
          dataMap:(NSDictionary *)dataMap
         delegate:(id<MolocoApiCallback>)apiCallback;

+ (void)sendCustomEvent:(CustomEventType)eventType
        customEventName:(NSString *)customEventName
                dataMap:(NSDictionary *)dataMap
               delegate:(id<MolocoApiCallback>)apiCallback;

@property (nonatomic, weak) id<MolocoApiCallback> delegate;
@property (nonatomic, retain) NSString *productId;
@property (nonatomic, retain) NSString *apiKey;

@end

#endif
