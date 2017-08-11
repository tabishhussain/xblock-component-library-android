# xblock-component-library


Requirements:

- Add the following line to project level gradile file
    maven { url 'https://maven.google.com'

    e.g
    allprojects {
    repositories {
        maven { url 'https://maven.google.com' }
        }
    }


- Add the following to dependencies of app level gradile
    compile 'com.google.android.exoplayer:exoplayer:r1.5.7'

     e.g
    dependencies {
      compile 'com.google.android.exoplayer:exoplayer:r1.5.7'
    }


