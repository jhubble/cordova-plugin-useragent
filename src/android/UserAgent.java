package im.ltdev.cordova;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.webkit.WebSettings;
import android.webkit.WebView;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;

public class UserAgent extends CordovaPlugin {

  public WebSettings settings;

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {

    super.initialize(cordova, webView);

    try {

      settings = ((WebView) webView.getEngine().getView()).getSettings();

    } catch (Exception error) {

      settings = null;

    }
  }

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    try {
      if (action.equals("setUserAgent")) {
        String text = args.getString(0);
        settings.setUserAgentString(text);
        callbackContext.success(settings.getUserAgentString());
        return true;
      } else if (action.equals("setAkamaiUserAgent")) {
          PackageManager packageManager = this.cordova.getActivity().getPackageManager();
          ApplicationInfo app = packageManager.getApplicationInfo(this.cordova.getActivity().getPackageName(), 0);

          String versionNumber = app.versionName;
          String appName = packageManager.getApplicationLabel(app);
          String userAgent = settings.getUserAgent();
          String newUserAgent = (appName+"/"+versionNumber+"("+userAgent+")");
          settings.setUserAgentString(newUserAgent);
          callbackContext.success(settings.getUserAgentString());
      } else if (action.equals("getUserAgent")) {
        callbackContext.success(settings.getUserAgentString());
        return true;
      } else if (action.equals("resetUserAgent")) {
        settings.setUserAgentString(null);
        callbackContext.success(settings.getUserAgentString());
        return true;
      } else if (action.equals("getAppName")) {
        PackageManager packageManager = this.cordova.getActivity().getPackageManager();
        ApplicationInfo app = packageManager.getApplicationInfo(this.cordova.getActivity().getPackageName(), 0);
        callbackContext.success((String) packageManager.getApplicationLabel(app));
        return true;
      } else if (action.equals("getPackageName")) {
        callbackContext.success(this.cordova.getActivity().getPackageName());
        return true;
      } else if (action.equals("getVersionNumber")) {
        PackageManager packageManager = this.cordova.getActivity().getPackageManager();
        callbackContext
            .success(packageManager.getPackageInfo(this.cordova.getActivity().getPackageName(), 0).versionName);
        return true;
      } else if (action.equals("getVersionCode")) {
        PackageManager packageManager = this.cordova.getActivity().getPackageManager();
        callbackContext
            .success(packageManager.getPackageInfo(this.cordova.getActivity().getPackageName(), 0).versionCode);
        return true;
      }
      return false;
    }

    catch (NameNotFoundException e) {
      callbackContext.success("N/A");
      return true;
    }
    callbackContext.error(e.getMessage());
    return false;
  }

}
