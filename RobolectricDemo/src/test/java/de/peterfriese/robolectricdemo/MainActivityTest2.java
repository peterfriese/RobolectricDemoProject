package de.peterfriese.robolectricdemo;

import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import de.peterfriese.robolectric.RobolectricGradleTestRunner;

import static org.fest.assertions.api.ANDROID.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest2 {

	private MainActivity activity;

	@Before
	public void setUp() {
		activity = Robolectric.buildActivity(MainActivity.class)
				.create()
				/* start and resume are needed to make sure the fragment is started */
				.start()
				.resume()
				.get();
	}

	@Test
	public void shouldBeNonNull() {
		assertThat(activity).isNotNull();
	}

	@Test public void shouldHaveTextViewWithHelloWorld() {
		TextView helloView = (TextView) activity.findViewById(R.id.textView);
		assertNotNull(helloView);
		Assert.assertThat((String) helloView.getText(), is("Hello world!"));

//		assertThat(helloView.getText()).isEqualTo("Hello world");
		assertThat(helloView).hasText("Hello world!");
	}

}
