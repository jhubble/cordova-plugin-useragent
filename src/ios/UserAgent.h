#import <Cordova/CDVPlugin.h>
#import <WebKit/WebKit.h>

@interface UserAgent : CDVPlugin

@property (nonatomic, strong) IBOutlet WKWebView* webView;

- (void)getUserAgent:(CDVInvokedUrlCommand*)command;

- (void)setUserAgent:(CDVInvokedUrlCommand*)command;

- (void)resetUserAgent:(CDVInvokedUrlCommand*)command;

- (void)getAppName:(CDVInvokedUrlCommand*)command;

- (void)getPackageName:(CDVInvokedUrlCommand*)command;

- (void)getVersionNumber:(CDVInvokedUrlCommand*)command;

- (void)getVersionCode:(CDVInvokedUrlCommand*)command;

- (void)setAkamaiUserAgent:(CDVInvokedUrlCommand*)command;

@end
