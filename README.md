# Nitrozen Android

## How to use?
- **Step 1:** Add following in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        //...
        maven { url 'https://www.jitpack.io' }
    }
}
```
- **Step 2:** Add the dependency
```groovy
dependencies {
    implementation 'com.github.gofynd:nitrozen-android:0.1.0'
}
```

## Components
- [Buttons](./assets/documents/buttons.md)
- [Typography](./assets/documents/typography.md)
- [TextFields](./assets/documents/textfields.md)
- [CheckBox](./assets/documents/checkbox.md)
- [RadioButton](./assets/documents/radiobutton.md)
- [Chip](./assets/documents/chip.md)
- [Switch](./assets/documents/switch.md)
- [Badge](./assets/documents/badge.md)
- [Stepper](./assets/documents/stepper.md)
- [DropDownTextField](./assets/documents/dropdowntextfield.md)
- [OTPField](./assets/documents/otpfield.md)
