package nasa.logic.parser;

import static nasa.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static nasa.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static nasa.logic.parser.CommandParserTestUtil.assertParseFailure;
import static nasa.logic.commands.CommandTestUtil.MODULE_DESC_CS1231;
import static nasa.logic.commands.CommandTestUtil.INVALID_MODULE_DESC;
import static nasa.logic.commands.CommandTestUtil.VALID_MODULE_CS1231;

import nasa.commons.core.index.Index;
import nasa.logic.commands.DeleteActivityCommand;
import nasa.model.module.ModuleCode;
import org.junit.jupiter.api.Test;
public class DeleteActivityCommandParserTest {

    private DeleteActivityCommandParser parser = new DeleteActivityCommandParser();
    private ModuleCode moduleCode = new ModuleCode(VALID_MODULE_CS1231);

    @Test
    public void parse_validArgs_returnsDeleteActivityCommand() {
        assertParseSuccess(parser, "1" + MODULE_DESC_CS1231, new DeleteActivityCommand(Index.fromOneBased(1), moduleCode));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        // no module stated in the user input
        assertParseFailure(parser, "1", String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteActivityCommand.MESSAGE_USAGE));

        // no index stated at all
        assertParseFailure(parser, MODULE_DESC_CS1231, String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteActivityCommand.MESSAGE_USAGE));

        // incorrect module code
        assertParseFailure(parser, INVALID_MODULE_DESC, String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteActivityCommand.MESSAGE_USAGE));
    }
}
