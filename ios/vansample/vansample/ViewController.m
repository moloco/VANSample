#import "ViewController.h"
#import <MolocoVANSDK/UserInfo.h>

@interface ViewController ()

@end

@implementation ViewController
@synthesize textView;

- (void)viewDidLoad {
	[super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
    // Set app name only if you want to set app name different from your bundle name.
	[[MolocoEntryPoint sharedInstance] setAppName:@"MolocoVanSample"];
}

- (void)didReceiveMemoryWarning {
	[super didReceiveMemoryWarning];
	// Dispose of any resources that can be recreated.
}

- (void)handleResponse:(NSString *)response {
    // Handle response from VAN server.
	NSLog(@"Response: %@",response);
	[textView setText:[NSString stringWithFormat:@"Response: %@", response]];

    // You can also access device and user information that VAN collected.
    UserInfo *userInfo = [UserInfo sharedInstance];
    NSLog(@"Response: %@\nIDFA: %@\nModel: %@\nCarrier: %@", response, [userInfo idfa], [userInfo model], [userInfo carrier]);
}

-(IBAction)clickSendBtn:(id)sender {
	NSMutableDictionary *dict = [[NSMutableDictionary alloc] init];
	[dict setValue:@"moloco" forKey:@"user"];
	[dict setValue:[NSNumber numberWithInt:31] forKey:@"age"];
	[dict setValue:[NSNumber numberWithFloat:0.124313f] forKey:@"latitude"];
	[dict setValue:[NSNumber numberWithFloat:0.717662f] forKey:@"longitude"];
	[MolocoEntryPoint sendEvent:@"ClickEvent" dataMap:dict delegate:self];
}

@end
