package NASA.logic.commands;

import static java.util.Objects.requireNonNull;
import static NASA.model.ModelNasa.PREDICATE_SHOW_ALL_MODULES;

import NASA.model.ModelNasa;

public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all persons";

    @Override
    public CommandResult execute(ModelNasa model) {
        requireNonNull(model);
        model.updateFilteredModuleList(PREDICATE_SHOW_ALL_MODULES);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
