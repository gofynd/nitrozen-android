package com.fynd.nitrozen.nitrozenloader;

public class SpriteFactory {

    public static Sprite create(Style style) {
        Sprite sprite = null;
        switch (style) {
            case THREE_BOUNCE:
                sprite = new ThreeBounce();
                break;
            default:
                break;
        }
        return sprite;
    }
}