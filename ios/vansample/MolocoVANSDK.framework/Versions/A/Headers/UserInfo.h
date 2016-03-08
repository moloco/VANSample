#ifndef VAN_SDK_UserInfo_h
#define VAN_SDK_UserInfo_h

#import <Foundation/Foundation.h>

@interface UserInfo : NSObject {
    BOOL _adTrackingEnabled;
    NSString *_queryString;
}

+ (id)sharedInstance;
- (void)initWithAppName:(NSString *)appName idfa:(NSString *)idfa dnt:(BOOL)dnt
                  model:(NSString *)model mcc:(NSString *)mcc mnc:(NSString *)mnc
             countryISO:(NSString *)countryISO carrier:(NSString *)carrier
                network:(NSString *)network tablet:(BOOL)tablet appVersion:(NSString *)appVersion
             apiVersion:(NSString *)apiVersion language:(NSString *)language os:(NSString *)os
              osVersion:(NSString *)osVersion;
- (BOOL)isAdTrackingEnabled;
- (NSString *)getQueryString:(NSDictionary *)dataMap;

@property (nonatomic, retain) NSString *appName;
@property (nonatomic, retain) NSString *idfa;
@property (nonatomic) BOOL dnt; //DO NOT Ttrack
@property (nonatomic, retain) NSString *model; //deviceinfo
@property (nonatomic, retain) NSString *mcc; //Mobile country code
@property (nonatomic, retain) NSString *mnc; //Mobile network code
@property (nonatomic, retain) NSString *countryISO;
@property (nonatomic, retain) NSString *carrier; //T-mobile, KT, SKT, etc
@property (nonatomic, retain) NSString *network; //WIFI, 3G, LTE, etc
@property (nonatomic) BOOL tablet; //isTablet
@property (nonatomic, retain) NSString *appVersion;
@property (nonatomic, retain) NSString *apiVersion;
@property (nonatomic, retain) NSString *language;
@property (nonatomic, retain) NSString *os;
@property (nonatomic, retain) NSString *osVersion;

@end

#endif
