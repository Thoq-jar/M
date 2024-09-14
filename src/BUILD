java_import(
    name = "math",
    data = ["main/resources/icon.png"],
    jars = ["lib/exp4j.jar"],
)

java_library(
    name = "lib",
    srcs = glob(["main/java/dev/thoq/**/*.java"]),
    data = ["main/resources/icon.png"],
    javacopts = [
        "-source",
        "21",
        "-target",
        "21",
    ],
    deps = [":math"],
)

java_binary(
    name = "M",
    srcs = ["main/java/dev/thoq/Main.java"],
    data = ["main/resources/icon.png"],
    javacopts = [
        "-source",
        "21",
        "-target",
        "21",
    ],
    main_class = "dev.thoq.Main",
    deps = [
        ":lib",
        ":math",
    ],
)
