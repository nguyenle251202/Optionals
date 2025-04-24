package enums;

public class Enum {
    public enum Option {
        AddUser(1),
        ViewAll(2),
        FindUserById(3),
        FindUsersByCity(4),
        FindUsersByEmailDomain(5),
        EXIT(0);

        private final int code;

        Option(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        // Tìm enum theo code
        public static Option fromCode(int code) {
            for (Option opt : Option.values()) {
                if (opt.code == code) return opt;
            }
            return null;
        }
    }
}
