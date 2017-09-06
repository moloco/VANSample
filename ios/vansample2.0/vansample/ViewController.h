#import <UIKit/UIKit.h>
#import <MolocoVANSDK/MolocoVAN.h>

@interface ViewController : UIViewController<MolocoApiCallback>

-(IBAction)clickSendBtn:(id)sender;
-(IBAction)clickCustomSendBtn:(id)sender;

@property (nonatomic, retain) IBOutlet UITextView *textView;

@end
