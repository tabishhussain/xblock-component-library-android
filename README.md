# xblock-component-library

XBlock component library is built to imitate the edX’s component architecture on the Android side where courses are built hierarchically of pieces called XBlocks. Following the guidelines of object oriented programming, a modular architecture is created to conveniently add any component (XBlock). The same set of classes would be needed to add a new component (XBlock) to this library. 

 Minimal effort is required to include a XBlock in your app. You can combine multiple XBlocks in a single activity or reuse them in multiple activities. You can think of XBlock as a modular section of your app, which has its own lifecycle , receives its own input event.  

Currently our XBlock library only includes one XBlock that's VideoXBlock, will add more XBlock soon.


## VideoXBlock

VideoXBlock provides the functionality of playing Ooyala Backlot videos. Underneath it is using Ooyala SDK. It creates an abstract layer on top of Ooyala SDK, which hides all the details of Ooyala SDK integration. It presents a interface to app through which app can get all the callback about video progress and state. It also includes a card with white background where video related information would be displayed (title, description). 

With no effort you can play Ooyala Backlot videos in your app. App just needs to provide a container Id where to show the XBlock. You don't need to worry about Ooyala player configurations, notifications and errors.

Currently VideoXBlock incorporate basic implementation of Ooyala player and does not provide any UI customization for Ooyala player layout.  

Following are the lines of code which would to integrate VideoXBlock in your app

```
XBlockInfo xBlockInfo = XBlockInfoBuilder.buildVideoXBlockInfo()
                .setTitle(TITLE)
                .setPcode(pcode)
                .setEmbedId(embedId)
                .setDomain(domain).build();

        final XBlock xBlock = XBlock.with(getChildFragmentManager(), R.id.xblock_container, xBlockInfo);
        xBlock.injectXBlock();
```
This repositry includes a sample app which demonstrates the use of VideoXBlock in an app. 

## Installing

No addition dependencies are require in case of using this repository xblocks directroy code as a module in Android studio project. 

In case of using AAR file the following dependencies would be required 
### Requirements:

- Add the following line to project level gradile file
    ``` maven { url 'https://maven.google.com'} ```

   ```
    e.g
    allprojects {
    repositories {
        maven { url 'https://maven.google.com' }
        }
    }
    
    ```


- Add the following to dependencies of app level gradile
     ``` compile 'com.google.android.exoplayer:exoplayer:r1.5.7' ```

    ```
     e.g
    dependencies {
      compile 'com.google.android.exoplayer:exoplayer:r1.5.7'
    }
    
    ```


