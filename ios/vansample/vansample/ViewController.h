#import <UIKit/UIKit.h>
#import <MolocoVANSDK/MolocoEntryPoint.h>

@interface ViewController : UIViewController<MolocoApiCallback>

-(IBAction)clickSendBtn:(id)sender;

@property (nonatomic, retain) IBOutlet UITextView *textView;

@end
