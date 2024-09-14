java_import(
    name = "math",
    jars = ["lib/exp4j.jar"],
)

java_library(
    name = "lib",
    srcs = glob(["main/java/dev/thoq/**/*.java"]),
    deps = [":math"],
)

java_binary(
    name = "M",
    srcs = ["main/java/dev/thoq/Main.java"],
    main_class = "dev.thoq.Main",
    deps = [
        ":lib",
        ":math",
    ],
)
