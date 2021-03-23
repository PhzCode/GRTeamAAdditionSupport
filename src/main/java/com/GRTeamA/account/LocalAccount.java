// Copyright (c) The  Core Contributors
// SPDX-License-Identifier: Apache-2.0

package com.GRTeamA.account;


import com.GRTeamA.types.AccountAddress;
import com.GRTeamA.types.AuthKey;
import com.GRTeamA.types.Ed25519PrivateKey;
import com.GRTeamA.types.PrivateKey;
import com.GRTeamA.utils.Hex;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;

import java.security.SecureRandom;

public class LocalAccount {
    public static LocalAccount generate() {
        return generate(new Ed25519PrivateKeyParameters(new SecureRandom()));
    }

    public static LocalAccount generate(String privateKeyHex) {
        byte[] privateKeyBytes = Hex.decode(privateKeyHex);
        return generate(new Ed25519PrivateKeyParameters(privateKeyBytes, 0));
    }

    private static LocalAccount generate(
            Ed25519PrivateKeyParameters privateKeyParams) {
        PrivateKey privateKey = new Ed25519PrivateKey(privateKeyParams);

        AuthKey authKey = AuthKey.ed24419(privateKey.publicKey());
        AccountAddress address = authKey.accountAddress();

        return new LocalAccount(address, authKey, privateKey);
    }

    public AccountAddress address;
    public AuthKey authKey;
    public PrivateKey privateKey;

    public LocalAccount(AccountAddress address, AuthKey authKey, PrivateKey privateKey) {
        this.address = address;
        this.authKey = authKey;
        this.privateKey = privateKey;
    }

    public static void main(String[] args) {
        LocalAccount parent = LocalAccount.generate();
        System.out.println("address = " + Hex.encode(parent.address.value));
        System.out.println("authKey = " + Hex.encode(parent.authKey.prefix()));
        System.out.println("sk = " + Hex.encode(parent.privateKey.privateKey()));
        System.out.println("pk = " + Hex.encode(parent.privateKey.publicKey()));
    }

}
