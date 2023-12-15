package org.livin.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.livin.pages.Docs_Page;
import org.livin.pages.Home_Page;
import org.livin.pages.Tutorial_Page;

import java.io.IOException;

public class Steps {

    Home_Page home = new Home_Page();
    Docs_Page docs = new Docs_Page();
    Tutorial_Page tutorial = new Tutorial_Page();

    @Given("^I Click on (.*) Tab$")
    public void clickDoc(String tabName) throws IOException {
        if (tabName.equalsIgnoreCase("Docs")) {
            home.clickDocsTab();
        } else if (tabName.equalsIgnoreCase("Tutorial")) {
            home.clickTutorialTab();
        }
    }

    @When("^I Expand (.*) button$")
    public void expandButton(String button) throws IOException {
        if (button.equalsIgnoreCase("Main Concept")) {
            docs.clickMainConcept();
        } else if (button.equalsIgnoreCase("Advanced Guide")) {
            docs.clickAdvancedGuide();
        }
    }

    @Then("^I Highlight the (.*) sub elements and save the sub elements in file$")
    public void highlightAndSaveSubElements(String button) throws IOException {
        if (button.equalsIgnoreCase("Main Concept")) {
            docs.getSubElementsMainConcept();
        } else if (button.equalsIgnoreCase("Advanced Guide")) {
            docs.getvSubElementsAdvancedGuide();
        }
    }

    @Then("^I verify the respected content is Bolded on Right Navigation and Blue color line is seen when I Scroll$")
    public void scrollAndValidateNavigationTableFontAndSelectionColor() throws IOException {
        tutorial.scrollAndValidateTableFontNadColor();
    }
}
