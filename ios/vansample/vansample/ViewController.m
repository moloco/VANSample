//
//  ViewController.m
//  vansample
//
//  Copyright (c) 2015년 Moloco. All rights reserved.
//

#import "ViewController.h"


#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController
@synthesize textView;

- (void)viewDidLoad {
	[super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
	[[MolocoEntryPoint sharedInstance] setAppName:@"moloco"];
	
}

- (void)didReceiveMemoryWarning {
	[super didReceiveMemoryWarning];
	// Dispose of any resources that can be recreated.
}

- (void)handleResponse:(NSDictionary *)response {
	NSLog(@"response : %@",response);
	[textView setText:[NSString stringWithFormat:@"%@", response]];
}

-(IBAction)clickPostBtn:(id)sender {
	NSMutableDictionary *dict = [[NSMutableDictionary alloc] init];
	[dict setValue:@"Ethan" forKey:@"user"];
	[dict setValue:[NSNumber numberWithInt:31] forKey:@"age"];
	[dict setValue:[NSNumber numberWithFloat:0.124313f] forKey:@"latitude"];
	[dict setValue:[NSNumber numberWithFloat:0.717662f] forKey:@"longitude"];
	[MolocoEntryPoint sendEvent:@"test" dataMap:dict delegate:self];
}

-(IBAction)clickGetBtn:(id)sender {
	[MolocoEntryPoint getEvent:@"test" delegate:self];
}

@end

