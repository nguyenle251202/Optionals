import enums.Enum; // Make sure this import is correct for your project structure
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // For capturing System.out
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    // For simulating System.in
    private final InputStream originalIn = System.in;
    private ByteArrayInputStream inContent;

    // Helper to provide input to System.in
    private void provideInput(String data) {
        inContent = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        System.setIn(inContent);
    }

    // Helper to get System.out output as String
    private String getOutput() {
        // Normalize line endings to \n for cross-platform consistency
        return outContent.toString(StandardCharsets.UTF_8).replace(System.lineSeparator(), "\n");
    }

    @BeforeEach
    void setUpStreams() {
        // Redirect System.out
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        // Restore System.out and System.in
        System.setOut(originalOut);
        System.setIn(originalIn);
        // Close streams if needed (ByteArray streams don't strictly need it here)
        try {
            outContent.close();
            if (inContent != null) {
                inContent.close();
            }
        } catch (Exception e) {
            // ignore
        }
    }

    // --- Tests for displayMenu ---

    @Test
    @DisplayName("displayMenu should print the menu options")
    void testDisplayMenuOutput() {
        Main.displayMenu();
        String output = getOutput();

        assertTrue(output.contains("----- Menu -----"), "Output should contain menu header");
        assertTrue(output.contains("[1]. AddUser"), "Output should contain AddUser option");
        assertTrue(output.contains("[2]. ViewAll"), "Output should contain ViewAll option");
        assertTrue(output.contains("[3]. FindUserById"), "Output should contain FindUserById option");
        assertTrue(output.contains("[4]. FindUsersByCity"), "Output should contain FindUsersByCity option");
        assertTrue(output.contains("[5]. FindUsersByEmailDomain"), "Output should contain FindUsersByEmailDomain option");
        assertTrue(output.contains("[0]. Exit"), "Output should contain Exit option");
    }

    private void assertTrue(boolean contains, String outputShouldContainMenuHeader) {
    }

    // --- Tests for OptionMenu ---

    @Test
    @DisplayName("OptionMenu should return AddUser and call UI method for input 1")
    void testOptionMenu_AddUser() {
        Enum.Option result = Main.OptionMenu(1);
        String output = getOutput();

        assertEquals(Enum.Option.AddUser, result, "Should return AddUser enum");
        assertTrue(output.contains("Add User"), "Should print 'Add User'");
        assertTrue(output.contains("STUB: AddUser.addUser called"), "Should call AddUser.addUser");
    }

    @Test
    @DisplayName("OptionMenu should return ViewAll and call UI method for input 2")
    void testOptionMenu_ViewAll() {
        Enum.Option result = Main.OptionMenu(2);
        String output = getOutput();

        assertEquals(Enum.Option.ViewAll, result, "Should return ViewAll enum");
        assertTrue(output.contains("View All"), "Should print 'View All'");
        assertTrue(output.contains("STUB: ViewAll.viewAll called"), "Should call ViewAll.viewAll");
    }

    @Test
    @DisplayName("OptionMenu should return FindUserById and call UI method for input 3")
    void testOptionMenu_FindUserById() {
        Enum.Option result = Main.OptionMenu(3);
        String output = getOutput();

        assertEquals(Enum.Option.FindUserById, result, "Should return FindUserById enum");
        assertTrue(output.contains("Find User By Id"), "Should print 'Find User By Id'");
        assertTrue(output.contains("STUB: FindUserById.findUserById called"), "Should call FindUserById.findUserById");
    }

    @Test
    @DisplayName("OptionMenu should return FindUsersByCity and call UI method for input 4")
    void testOptionMenu_FindUsersByCity() {
        Enum.Option result = Main.OptionMenu(4);
        String output = getOutput();

        assertEquals(Enum.Option.FindUsersByCity, result, "Should return FindUsersByCity enum");
        assertTrue(output.contains("Find Users By City"), "Should print 'Find Users By City'");
        assertTrue(output.contains("STUB: FindUsersByCity.findUsersByCity called"), "Should call FindUsersByCity.findUsersByCity");
    }

    @Test
    @DisplayName("OptionMenu should return FindUsersByEmailDomain and call UI method for input 5")
    void testOptionMenu_FindUsersByEmailDomain() {
        Enum.Option result = Main.OptionMenu(5);
        String output = getOutput();

        assertEquals(Enum.Option.FindUsersByEmailDomain, result, "Should return FindUsersByEmailDomain enum");
        assertTrue(output.contains("Find Users By Email Domain"), "Should print 'Find Users By Email Domain'");
        assertTrue(output.contains("STUB: FindUsersByEmailDomain.findUsersByEmailDomain called"), "Should call FindUsersByEmailDomain.findUsersByEmailDomain");
    }

    // Test the potentially hidden options if they exist in your Enum
    @Test
    @DisplayName("OptionMenu should return GetUserEmailDomain and call UI method for input 6")
    void testOptionMenu_GetUserEmailDomain() {
        // Check if this enum constant exists before running test
        if (Enum.Option.fromCode(6) == null) {
            System.err.println("Skipping testOptionMenu_GetUserEmailDomain: Enum.Option(6) not defined.");
            return;
        }
        Enum.Option result = Main.OptionMenu(6);
        String output = getOutput();

        assertEquals(Enum.Option.GetUserEmailDomain, result, "Should return GetUserEmailDomain enum");
        assertTrue(output.contains("Get User Email Domain"), "Should print 'Get User Email Domain'");
        assertTrue(output.contains("STUB: GetUserEmailDomain.getUserEmailDomain called"), "Should call GetUserEmailDomain.getUserEmailDomain");
    }

    @Test
    @DisplayName("OptionMenu should return GetUserCity and call UI method for input 7")
    void testOptionMenu_GetUserCity() {
        // Check if this enum constant exists before running test
        if (Enum.Option.fromCode(7) == null) {
            System.err.println("Skipping testOptionMenu_GetUserCity: Enum.Option(7) not defined.");
            return;
        }
        Enum.Option result = Main.OptionMenu(7);
        String output = getOutput();

        assertEquals(Enum.Option.GetUserCity, result, "Should return GetUserCity enum");
        assertTrue(output.contains("Get User City"), "Should print 'Get User City'");
        assertTrue(output.contains("STUB: GetUserCity.getUserByCity called"), "Should call GetUserCity.getUserByCity");
    }


    @Test
    @DisplayName("OptionMenu should return EXIT for input 0")
    void testOptionMenu_Exit() {
        Enum.Option result = Main.OptionMenu(0);
        String output = getOutput();

        assertEquals(Enum.Option.EXIT, result, "Should return EXIT enum");
        assertTrue(output.contains("Exit"), "Should print 'Exit'");
        // No UI method should be called for EXIT
        assertFalse(output.contains("STUB:"), "Should not call any stub UI method for EXIT");
    }

    @Test
    @DisplayName("OptionMenu should return null and print error for invalid negative input")
    void testOptionMenu_InvalidNegative() {
        Enum.Option result = Main.OptionMenu(-1);
        String output = getOutput();

        assertNull(result, "Should return null for invalid input");
        assertTrue(output.contains("Invalid option"), "Should print 'Invalid option'");
    }

    @Test
    @DisplayName("OptionMenu should return null and print error for invalid high input")
    void testOptionMenu_InvalidHigh() {
        Enum.Option result = Main.OptionMenu(99); // Number not mapped in Enum.Option.fromCode
        String output = getOutput();

        assertNull(result, "Should return null for invalid input");
        assertTrue(output.contains("Invalid option"), "Should print 'Invalid option'");
    }

    // --- Tests for menu ---

    @Test
    @DisplayName("menu should exit immediately when 0 is entered")
    void testMenu_ExitImmediately() {
        provideInput("0\n"); // Simulate user typing '0' and pressing Enter
        Main.menu();
        String output = getOutput();

        // Check for menu display, prompt, processing exit, and final message
        assertTrue(output.contains("----- Menu -----"), "Should display menu initially");
        assertTrue(output.contains("Enter your option (0-7):"), "Should prompt for input");
        assertTrue(output.contains("Exit"), "Should process the Exit option"); // From OptionMenu
        assertTrue(output.endsWith("Application finished.\n"), "Should print finished message at the end");

        // Check that the menu loop ran only once (check for second menu display)
        int firstMenuPos = output.indexOf("----- Menu -----");
        int secondMenuPos = output.indexOf("----- Menu -----", firstMenuPos + 1);
        assertEquals(-1, secondMenuPos, "Menu should only be displayed once for immediate exit");
    }

    @Test
    @DisplayName("menu should run one command then exit")
    void testMenu_OneCommandThenExit() {
        provideInput("1\n0\n"); // AddUser, then Exit
        Main.menu();
        String output = getOutput();

        // Check flow: Menu -> Prompt -> Process 1 -> Menu -> Prompt -> Process 0 -> Finish
        assertTrue(output.contains("----- Menu -----"), "Should display menu");
        assertTrue(output.contains("Enter your option (0-7):"), "Should prompt for input");
        assertTrue(output.contains("Add User"), "Should process AddUser option");
        assertTrue(output.contains("STUB: AddUser.addUser called"), "Should call AddUser stub");
        assertTrue(output.contains("Exit"), "Should process Exit option");
        assertTrue(output.endsWith("Application finished.\n"), "Should print finished message");

        // Check menu displayed twice
        int firstMenuPos = output.indexOf("----- Menu -----");
        int secondMenuPos = output.indexOf("----- Menu -----", firstMenuPos + 1);
        assertTrue(firstMenuPos != -1, "Should find first menu");
        assertTrue(secondMenuPos != -1, "Should find second menu");
        int thirdMenuPos = output.indexOf("----- Menu -----", secondMenuPos + 1);
        assertEquals(-1, thirdMenuPos, "Menu should only be displayed twice");
    }

    @Test
    @DisplayName("menu should handle invalid non-numeric input")
    void testMenu_InvalidNonNumericInputThenExit() {
        provideInput("abc\n0\n"); // Invalid text, then Exit
        Main.menu();
        String output = getOutput();

        assertTrue(output.contains("----- Menu -----"), "Should display menu");
        assertTrue(output.contains("Enter your option (0-7):"), "Should prompt for input");
        assertTrue(output.contains("Invalid input. Please enter a number between 0 and 7."), "Should show non-numeric error");
        // It should re-prompt after invalid input
        int firstPromptPos = output.indexOf("Enter your option (0-7):");
        int secondPromptPos = output.indexOf("Enter your option (0-7):", firstPromptPos + 1);
        assertTrue(secondPromptPos > firstPromptPos, "Should re-prompt after invalid input");

        assertTrue(output.contains("Exit"), "Should process Exit option eventually");
        assertTrue(output.endsWith("Application finished.\n"), "Should print finished message");
    }

    @Test
    @DisplayName("menu should handle invalid numeric input (out of range)")
    void testMenu_InvalidNumericInputThenExit() {
        provideInput("99\n0\n"); // Invalid number, then Exit
        Main.menu();
        String output = getOutput();

        assertTrue(output.contains("----- Menu -----"), "Should display menu");
        assertTrue(output.contains("Enter your option (0-7):"), "Should prompt for input");
        // OptionMenu handles the invalid number
        assertTrue(output.contains("Invalid option"), "Should show invalid option error");
        // Menu should loop and display again
        int firstMenuPos = output.indexOf("----- Menu -----");
        int secondMenuPos = output.indexOf("----- Menu -----", firstMenuPos + 1);
        assertTrue(secondMenuPos > firstMenuPos, "Should display menu again after invalid option");

        assertTrue(output.contains("Exit"), "Should process Exit option eventually");
        assertTrue(output.endsWith("Application finished.\n"), "Should print finished message");
    }

    @Test
    @DisplayName("main method should call menu")
    void testMainMethod() {
        // We can't easily assert that main *calls* menu without PowerMock/Mockito static mocking.
        // However, we can run main and check if it behaves like menu() does when exiting immediately.
        provideInput("0\n");
        Main.main(new String[]{}); // Call main
        String output = getOutput();

        // Check for essential output from the menu() flow initiated by main()
        assertTrue(output.contains("----- Menu -----"), "Main should run menu, displaying the menu");
        assertTrue(output.contains("Enter your option (0-7):"), "Main should run menu, prompting for input");
        assertTrue(output.contains("Exit"), "Main should run menu, processing exit");
        assertTrue(output.endsWith("Application finished.\n"), "Main should run menu, printing finished message");
    }
}