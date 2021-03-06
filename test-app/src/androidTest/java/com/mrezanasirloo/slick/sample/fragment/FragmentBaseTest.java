/*
 * Copyright 2018. M. Reza Nasirloo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mrezanasirloo.slick.sample.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.mrezanasirloo.slick.sample.MainActivity;
import com.mrezanasirloo.slick.sample.R;
import com.mrezanasirloo.slick.sample.activity.ActivityBaseTest;
import com.mrezanasirloo.slick.sample.activity.ViewTestable;

import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * @author : M.Reza.Nasirloo@gmail.com
 *         Created on: 2018-03-10
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public abstract class FragmentBaseTest extends ActivityBaseTest {
    @Before
    public void setUp() {
        MainActivity activity = testRule.getActivity();
        activity.startActivity(new Intent(activity, ActivityFragmentHost.class));
        ActivityFragmentHost currentActivity = (ActivityFragmentHost) getCurrentActivity();
        assert currentActivity != null;
        Fragment fragment = createFragment();
        currentActivity.getFragmentManager().beginTransaction()
                .replace(R.id.fragment, fragment)
                .addToBackStack(null)
                .commit();
        view = (ViewTestable) fragment;
    }

    @NonNull
    protected abstract Fragment createFragment();
}
