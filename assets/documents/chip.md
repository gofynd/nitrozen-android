# Chip

## Normal
```kotlin
NitrozenChip(
    modifier = Modifier
        .padding(top = 16.dp),
    text = "Text"
)
```

## Leading Icon
```kotlin
NitrozenChip(
    modifier = Modifier
        .padding(top = 16.dp),
    text = "Person",
    leading = {
        Icon(
            imageVector = Icons.Outlined.Person,
            contentDescription = null,
        )
    }
)
```

## Trailing Icon
```kotlin
NitrozenChip(
    modifier = Modifier
        .padding(top = 16.dp),
    text = "Item",
    trailing = {
        Icon(
            imageVector = Icons.Outlined.Clear,
            contentDescription = null,
        )
    }
)
```

## Leading And Trailing Icon
```kotlin
NitrozenChip(
    modifier = Modifier
        .padding(top = 16.dp),
    text = "email",
    trailing = {
        Icon(
            imageVector = Icons.Outlined.Clear,
            contentDescription = null,
        )
    },
    leading = {
        Icon(
            imageVector = Icons.Outlined.Person,
            contentDescription = null,
        )
    }
)
```

## Clickable
```kotlin
NitrozenChip(
    modifier = Modifier
        .padding(top = 16.dp),
    text = "Tap Here",
    onClick = {}
)
```

## Color Customization
```kotlin
NitrozenChip(
    modifier = Modifier
        .padding(top = 16.dp),
    text = "Custom",
    style = NitrozenChipStyle.Default.copy(
        backgroundColor = NitrozenTheme.colors.warning20,
        borderColor = NitrozenTheme.colors.warning80,
        textColor = NitrozenTheme.colors.warning80,
    )
)
```

## Preview
![](./../screenshots/chip.png)