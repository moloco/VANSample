#import <Foundation/Foundation.h>

#ifndef VAN_SDK_Constants_h
#define VAN_SDK_Constants_h

extern NSString* const VAN_SDK_API_VERSION;
extern NSString* const VAN_O_EVENT_URI;
extern NSString* const VAN_P_EVENT_URI;

// DeviceType enumeration
typedef enum {
    UNKNOWN_DEVICE = 0,
    PHONE = 1,
    TABLET = 2,
    PERSONAL_COMPUTER = 3,
    CONNECTED_DEVICE = 4,
    CONNECTED_TV = 5
} DeviceType;

// OEventType enumeration
typedef enum {
    O_INSTALL = 11,
    O_OPEN = 12,
    O_SESSION = 13
} OEventType;

// EventType enumeration
typedef enum {
    PURCHASE = 21,
    REGISTER = 22,
    OPEN_COMMUNITY = 23,
    INVITE = 24,
    CALL = 25,
    DELIVERY = 26,
    AUTHORIZE = 27,
    ADD_TO_CART = 28,
    ADD_TO_WISHLIST = 29,
    VIEW_CONTENT = 30,
    LEVEL_UP = 31,
    LOGIN = 32,
    RATE = 33,
    RESERVE = 34,
    SEARCH = 35,
    SELL = 36,
    SHARE = 37,
    COMPLETE_TUTORIAL = 38
} EventType;

// CustomEventType enumeration
typedef enum {
    CUSTOM_00 = 100,
    CUSTOM_01 = 101,
    CUSTOM_02 = 102,
    CUSTOM_03 = 103,
    CUSTOM_04 = 104,
    CUSTOM_05 = 105,
    CUSTOM_06 = 106,
    CUSTOM_07 = 107,
    CUSTOM_08 = 108,
    CUSTOM_09 = 109,
    CUSTOM_10 = 110,
    CUSTOM_11 = 111,
    CUSTOM_12 = 112,
    CUSTOM_13 = 113,
    CUSTOM_14 = 114,
    CUSTOM_15 = 115
} CustomEventType;

#endif
