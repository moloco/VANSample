//
//  ViewController.h
//  vansample
//
//  Copyright (c) 2015년 Moloco. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <MolocoVANSDK/MolocoEntryPoint.h>

@interface ViewController : UIViewController<MolocoApiCallback>


-(IBAction)clickPostBtn:(id)sender;
-(IBAction)clickGetBtn:(id)sender;

@property (nonatomic, retain) IBOutlet UITextView *textView;

@end

