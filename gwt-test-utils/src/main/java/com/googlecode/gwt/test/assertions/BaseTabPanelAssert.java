package com.googlecode.gwt.test.assertions;

import static org.fest.util.Objects.areEqual;

import com.google.gwt.user.client.ui.TabPanel;

/**
 * Base class for all {@link TabPanel} assertions.
 * 
 * @author Gael Lazzari
 * 
 * @param <S> used to simulate "self types." For more information please read &quot;<a href=
 *           "http://passion.forco.de/content/emulating-self-types-using-java-generics-simplify-fluent-api-implementation"
 *           target="_blank">Emulating 'self types' using Java Generics to simplify fluent API
 *           implementation</a>.&quot;
 * @param <A> the type of the "actual" value.
 */
public class BaseTabPanelAssert<S extends BaseTabPanelAssert<S, A>, A extends TabPanel> extends
         BaseWidgetAssert<S, A> {

   /**
    * Creates a new <code>{@link BaseTabPanelAssert}</code>.
    * 
    * @param actual the actual value to verify.
    * @param selfType the "self type."
    */
   protected BaseTabPanelAssert(A actual, Class<S> selfType) {
      super(actual, selfType);
   }

   /**
    * Verifies that the actual {@link TabPanel} disables animation.
    * 
    * @return this assertion object.
    * @throws AssertionError if the actual {@link TabPanel} enables animation.
    * 
    * @see TabPanel#isAnimationEnabled()
    */
   public S isAnimationDisabled() {
      if (!actual.isAnimationEnabled())
         return myself;

      throw failWithMessage("should disables animation");

   }

   /**
    * Verifies that the actual {@link TabPanel} enables animation.
    * 
    * @return this assertion object.
    * @throws AssertionError if the actual {@link TabPanel} disables animation.
    * 
    * @see TabPanel#isAnimationEnabled()
    */
   public S isAnimationEnabled() {
      if (actual.isAnimationEnabled())
         return myself;

      throw failWithMessage("should enable animation");
   }

   /**
    * Verifies that the actual {@link TabPanel} child widget count is equal to the given one.
    * 
    * @param expected the expected widget count.
    * @return this assertion object.
    * @throws AssertionError if the actual widget count is not equal to the given one.
    * 
    * @see TabPanel#getWidgetCount()
    */
   public S widgetCountEquals(int expected) {
      int widgetCount = actual.getWidgetCount();
      if (areEqual(widgetCount, expected))
         return myself;
      throw propertyComparisonFailed("WidgetCount", widgetCount, expected);
   }

}
