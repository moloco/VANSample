#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController
@synthesize textView;

- (void)viewDidLoad {
    [super viewDidLoad];
    
    // Do any additional setup after loading the view, typically from a nib.
    
    [MolocoVAN setProductId:@"sdk_sample_ios" apiKey:@"7ac2448786ad409093a079fd2bc46c28"];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)onSuccessResponse:(NSString *)response {
    NSLog(@"Successfully sent event with response : %@", response);
    [textView setText:@"Success!"];
}

- (void)onFailureResponse:(NSString *)response {
    NSLog(@"Failed to send event with response : %@", response);
    [textView setText:[NSString stringWithFormat:@"Fail response: %@", response]];
}

- (IBAction)clickSendBtn:(id)sender {
    NSMutableDictionary *dict = [[NSMutableDictionary alloc] init];
    [dict setValue:@"Moloco" forKey:@"user"];
    [dict setValue:[NSNumber numberWithInt:31] forKey:@"age"];
    [dict setValue:[NSNumber numberWithFloat:0.124313f] forKey:@"latitude"];
    [dict setValue:[NSNumber numberWithFloat:0.717662f] forKey:@"longitude"];
    
    // Send Event
    [MolocoVAN sendEvent:PURCHASE
                        dataMap:dict
                       delegate:self];
}

- (IBAction)clickCustomSendBtn:(id)sender {
    NSMutableDictionary *dict = [[NSMutableDictionary alloc] init];
    [dict setValue:@"Moloco" forKey:@"user"];
    [dict setValue:@"Seoul" forKey:@"location"];
    [dict setValue:@"11:11PM" forKey:@"time"];

    // Send Custom Event
    [MolocoVAN sendCustomEvent:CUSTOM_00
                      customEventName:@"my_custom_ios_event"
                              dataMap:dict
                             delegate:self];
}

@end
