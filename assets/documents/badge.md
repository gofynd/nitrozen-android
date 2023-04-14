# Badge

## Default
```kotlin
NitrozenBadge(
    modifier = Modifier
        .padding(top = 16.dp),
    text = "Badge"
)
```
## Warning
```kotlin
NitrozenBadge(
    modifier = Modifier
        .padding(top = 16.dp),
    text = "Badge",
    style = NitrozenBadgeStyle(
        backgroundColor = NitrozenTheme.colors.warning20,
        textColor = NitrozenTheme.colors.warning80,
        textStyle = NitrozenTheme.typography.bodySmall
    )
)
```
## Success
```kotlin
NitrozenBadge(
    modifier = Modifier
        .padding(top = 16.dp),
    text = "Badge",
    style = NitrozenBadgeStyle(
        backgroundColor = NitrozenTheme.colors.success20,
        textColor = NitrozenTheme.colors.success80,
        textStyle = NitrozenTheme.typography.bodySmall
    )
)
```
## Error
```kotlin
NitrozenBadge(
    modifier = Modifier
        .padding(top = 16.dp),
    text = "Badge",
    style = NitrozenBadgeStyle(
        backgroundColor = NitrozenTheme.colors.error20,
        textColor = NitrozenTheme.colors.error80,
        textStyle = NitrozenTheme.typography.bodySmall
    )
)
```

## Preview
![](./../screenshots/badge.png)