package com.georgiancollege.ryanclements.comp3026.lesson1.ex1;

import java.io.Serializable;

class FlawedFence implements Serializable {
    // 30 meters / 3 meters apart = 10 fence posts required
    private int requiredFencePosts = 10;
    transient FencePost[] fencePosts = new FencePost[requiredFencePosts];

    // 30 meters / 3 meters apart = 10 fence sections required
    private int requiredSectionsofFence = 10;
    transient FenceSection[] fenceSections = new FenceSection[requiredSectionsofFence];

    FlawedFence() {
        // create the fence posts
        for (int i=0;i<=fencePosts.length-1;i++) {
            fencePosts[i] = new FencePost();
        }
        // create the sections of fence
        for (int i=0;i<=fenceSections.length-1;i++) {
            fenceSections[i] = new FenceSection();
        }
    }
}