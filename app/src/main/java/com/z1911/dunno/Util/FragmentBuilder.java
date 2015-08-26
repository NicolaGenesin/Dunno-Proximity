package com.z1911.dunno.Util;

/**
 * Created by NicolaWin on 26/08/2015.
 */
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FragmentBuilder<F extends Fragment> implements Builder<F> {

    @Nonnull
    private Context context;

    @Nonnull
    private Class<? extends F> fragmentClass;

    @Nullable
    private Bundle fragmentArgs;

    private FragmentBuilder(@Nonnull Context context, @Nonnull Class<? extends F> fragmentClass, @Nullable Bundle fragmentArgs) {
        this.context = context;
        this.fragmentClass = fragmentClass;
        this.fragmentArgs = fragmentArgs;
    }

    @Nonnull
    public static <F extends Fragment> FragmentBuilder<F> forClass(@Nonnull Context context, @Nonnull Class<? extends F> fragmentClass, @Nullable Bundle fragmentArgs) {
        return new FragmentBuilder<F>(context, fragmentClass, fragmentArgs);
    }

    @Nonnull
    @Override
    public F build() {
        return (F) Fragment.instantiate(context, fragmentClass.getName(), fragmentArgs);
    }
}

