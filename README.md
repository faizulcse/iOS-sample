# iOS-sample
To run the app on real device you must have web driver agent setup
* Step 1: Clone the git repo from this link: `https://github.com/faizulcse/iOS-sample.git`
* Step 2: Goto root dir of the project create a folder called app and put your iOS app (ipa file) here
* Step 3: Open `SetupTest.java` file (`src/test/java/testcases/SetupTest.java`)
* Step 4: change this line:
From:
```
caps.setCapability("app", System.getProperty("user.dir") + "/app/demo-app.ipa");
```
To:
```
caps.setCapability("app", System.getProperty("user.dir") + "/app/YourApp.ipa);
```
Also change:
From:
```
caps.setCapability("platformVersion", "14.4");
caps.setCapability("version", "14.4");
caps.setCapability("udid", System.getenv("UDID"));
```
To:
```
caps.setCapability("platformVersion", “Your device version”);
caps.setCapability("version", "Your device version");
caps.setCapability("udid", “your device udid”);
```

To get your device’s udid run this command in the terminal after connecting your device: `ios-deploy -c`

Step 5: Go to `LoginTest.java` and run the test

