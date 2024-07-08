// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.example.graphwebhook;

import com.microsoft.graph.models.Subscription;
import jakarta.annotation.Nonnull;
import org.springframework.lang.NonNull;

/**
 * Represents a subscription created by the application
 */
public class SubscriptionRecord {

    /**
     * The subscription ID returned by Microsoft Graph when the subscription is created
     */
    public final @Nonnull String subscriptionId;

    /**
     * For delegated auth, this is the user's ID used to create the subscription. For app-only auth,
     * this is "APP-ONLY"
     */
    public final @Nonnull String userId;

    /**
     * The client state value used to create the subscription. All notifications generated by this
     * subscription MUST send this value
     */
    public final @Nonnull String clientState;

    public SubscriptionRecord(@Nonnull final String subscriptionId, @Nonnull final String userId,
            @NonNull final String clientState) {
        this.subscriptionId = subscriptionId;
        this.userId = userId;
        this.clientState = clientState;
    }

    public SubscriptionRecord(Subscription subscription) {
        this.subscriptionId = subscription.getId();
        this.userId = subscription.getCreatorId();
        this.clientState = subscription.getClientState();
    }
}
