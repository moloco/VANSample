//
//  ViewController.swift
//  VanSampleSwift
//
//  Created by Hyeonseo Ku on 7/23/16.
//  Copyright © 2016 Moloco, Inc. All rights reserved.
//

import UIKit

class ViewController: UIViewController, MolocoApiCallback {
    @IBOutlet weak var textView: UITextView!

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        // Set app name only if you want to set app name different from your bundle name.
        MolocoEntryPoint.setAppName("MolocoVanSwiftSample")
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func sendEvent(_ sender: UIButton) {
        let dataMap: NSMutableDictionary = [
            "user": "moloco",
            "age": "31",
            "latitude": "0.124313",
            "longitude": "0.717662"
        ]
        MolocoEntryPoint.sendEvent("ClickEvent", dataMap: dataMap as [NSObject: AnyObject], delegate: self)
    }

    func handleVANResponse(_ response: String!) {
        // Handle response from VAN server.
        textView.text = "Response = \(response)"
        
        // You can also access device and user information that VAN collected.
        let userInfo = UserInfo.sharedInstance() as AnyObject?
        print("Response = \(response)\nIDFA = \(userInfo?.idfa)\nOS = \(userInfo?.os)\nCarrier = \(userInfo?.carrier)\n")
    }

}

