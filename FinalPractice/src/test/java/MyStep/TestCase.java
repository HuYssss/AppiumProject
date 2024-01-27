package MyStep;

import Page.DashboardPage;
import Page.ActionsBlockPage;
import Page.ActionBlockComponent.AddActionPage;
import Page.MarcoComponent.ActionsPage;
import Page.MarcoComponent.ConstrainsPage;
import Page.MarcoComponent.TriggerPage;
import Page.MarcoComponent.VariablesPage;
import Page.MarcoPage;
import Page.StartPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Driver.DriverFactory;
import org.testng.Assert;

import java.net.MalformedURLException;

public class TestCase {
    public AppiumDriver _driver;
    public MarcoPage marcoPage;
    public ActionsPage actionsPage;
    public TriggerPage triggerPage;
    public ConstrainsPage constrainsPage;
    public VariablesPage variablesPage;
    public AddActionPage addActionPage;
    final String triggerOptions = "Application Removed";
    final String actionsOptions = "System Log";
    final String constrainsOptions = "Airplane Mode Disabled";
    final String name = "HuyHL Action Blocks";
    final String description = "This is description !!!";

    @Before
    public void before_all() throws MalformedURLException {
        this._driver = DriverFactory.getDriver();
    }

    @Given("the user opens the application")
    public void theUserOpensTheApplication() {
        StartPage startPage = new StartPage(this._driver);
        startPage.skipIntro();
        startPage.skipIntro2();
    }

    @When("the user navigates to the Macro section from the Dashboard")
    public void theUserNavigatesToTheMacroSectionFromTheDashboard() {
        DashboardPage dashboardPage = new DashboardPage(this._driver);
        dashboardPage.navigateToMarco();
    }

    @And("the user adds a trigger for the Macro")
    public void theUserAddsATriggerForTheMacroBySelectingAnApplicationAndTheEvent() {
        marcoPage = new MarcoPage(this._driver);

        marcoPage.addNewTrigger();

        triggerPage = new TriggerPage(this._driver);
        triggerPage.clickApplication();
        triggerPage.clickInsReUpdate();
        triggerPage.selectOptions(triggerOptions);
        triggerPage.clickOK();
        triggerPage.selectAnyApp();
        triggerPage.clickOK();
    }

    @And("the user adds an action for the Macro")
    public void theUserAddsAnActionForTheMacroBySelectingAndForTheSystemLog() {
        marcoPage.addNewActions();

        actionsPage = new ActionsPage(this._driver);
        actionsPage.clickLogging();
        actionsPage.clickClearLog();
        actionsPage.selectOption(actionsOptions);
        actionsPage.clickOK();
    }

    @And("the user adds constraints to the Macro")
    public void theUserAddsConstraintsToTheMacroBySelectingTheDeviceStateAndChoosing() {
        marcoPage.addNewConstrains();

        constrainsPage = new ConstrainsPage(this._driver);
        constrainsPage.DeviceState();
        constrainsPage.AirPlaneMode();
        constrainsPage.selectOptions(constrainsOptions);
        constrainsPage.OK();
    }

    @And("the user adds a local variable")
    public void theUserAddsALocalVariableNamedWithAValueOf() {
        marcoPage.addNewVariable();

        variablesPage = new VariablesPage(this._driver);
        variablesPage.setVariables();
        variablesPage.OK();
        variablesPage.setInputValue();
        variablesPage.OK();
    }

    @And("confirm trigger information")
    public void confirmTriggerInformation() {
        Assert.assertTrue(triggerPage.verifyAddTrigger(triggerOptions));
    }

    @And("confirm action information")
    public void confirmActionInformation() {
        Assert.assertTrue(actionsPage.verifyAddActions(actionsOptions));
    }

    @Then("confirm local variable information")
    public void confirmLocalVariableInformation() {
        Assert.assertTrue(variablesPage.verifyVariables());
    }

    @And("confirm constraints information")
    public void confirmConstraintsInformation() {
        Assert.assertTrue(constrainsPage.verifyAddConstrains(constrainsOptions));
    }

    @When("the user navigates to the Action Block from the Dashboard")
    public void theUserNavigatesToTheActionBlockFromTheDashboard() {
        DashboardPage dashboardPage = new DashboardPage(this._driver);
        dashboardPage.navigateActionBlock();
    }

    @And("the user adds Action Block Detail")
    public void theUserAddsActionBlockDetail() {
        ActionsBlockPage actionsBlockPage = new ActionsBlockPage(this._driver);
        actionsBlockPage.addNewActionBlock();

        addActionPage = new AddActionPage(this._driver);
        addActionPage.addNameDes(name, description);
    }

    @And("the user adds input variable")
    public void theUserAddsInputVariable() {
        addActionPage.addInputValue("This is Input Testing Data !!!");
        addActionPage.OK();
        addActionPage.setInputValueTrue();
        addActionPage.OK();
    }

    @And("the user adds action")
    public void theUserAddsAction() {
        addActionPage.addAction();

        actionsPage = new ActionsPage(this._driver);
        actionsPage.clickLogging();
        actionsPage.clickClearLog();
        actionsPage.selectOption(actionsOptions);
        actionsPage.clickOK();
    }

    @And("the user adds output variable")
    public void theUserAddsOutputVariable() {
        addActionPage.addOutput();
        addActionPage.OK();

        Assert.assertTrue(addActionPage.verifyOutPut());
    }

    @Then("confirm Action Block information")
    public void confirmActionBlockInformation() {
        addActionPage.confirmInformation();
    }

    @And("confirm Action Block name and description")
    public void confirmActionBlockNameAndDescription() {
        Assert.assertTrue(addActionPage.verifyActionBookName(name));
    }
}
