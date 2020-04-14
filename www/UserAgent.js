var noop = function(){};
var UserAgent = {
    setUserAgent: function (text, success, fail) {
    	text = text||""; // Empty is the same as issuing reset.
        cordova.exec(success||noop, fail||noop, "UserAgent", "setUserAgent", [text]);
    },
    getUserAgent: function (success, fail) {
        if (success) {
           cordova.exec(success, fail||noop, "UserAgent", "getUserAgent", []);
         } else {
           return false;
        }
    },
    resetUserAgent: function (success, fail) {
        cordova.exec(success||noop, fail||noop, "UserAgent", "resetUserAgent", []);
    },
    getAppName: function (success, fail) {
      if (success) {
         cordova.exec(success, fail||noop, "UserAgent", "getAppName", []);
       } else {
         return false;
      }
    },

    getVersionNumber: function (success, fail) {
      if (success) {
         cordova.exec(success, fail||noop, "UserAgent", "getVersionNumber", []);
       } else {
         return false;
      }
    },


    getVersionCode: function (success, fail) {
      if (success) {
         cordova.exec(success, fail||noop, "UserAgent", "getVersionCode", []);
       } else {
         return false;
      }
    },

    getPackageName: function (success, fail) {
      if (success) {
         cordova.exec(success, fail||noop, "UserAgent", "getPackageName", []);
       } else {
         return false;
      }
    },

    setAkamaiUserAgent: function (success, fail) {
      if (success) {
        cordova.exec(success, fail||noop, "UserAgent", "setAkamaiUserAgent", []);
      } else {
        return false;
     } 
    }
  };

    // MyMobileApp/1.2.3 (iPhone; iOS 11.2.1)
    const initializeUserAgent = function (success, fail) {
      UserAgent.getAppNam


    }


module.exports = UserAgent;
