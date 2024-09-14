java_import(
    name = "external",
    jars = [
        "lib/exp4j.jar",
        "lib/guava-jre.jar",
        "lib/guava.jar",
    ],
)

java_library(
    name = "lib",
    srcs = glob(["main/java/dev/thoq/**/*.java"]),
    javacopts = [
        "-source",
        "21",
        "-target",
        "21",
    ],
    deps = [":external"],
)

java_binary(
    name = "M",
    srcs = ["main/java/dev/thoq/Main.java"],
    javacopts = [
        "-source",
        "21",
        "-target",
        "21",
    ],
    main_class = "dev.thoq.Main",
    deps = [
        ":external",
        ":lib",
    ],
)
