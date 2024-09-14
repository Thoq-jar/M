java_library(
    name = "lib",
    srcs = glob(["src/main/java/dev/thoq/**/*.java"]),
    javacopts = [
        "--source=21",
        "--target=21",
    ],
    deps = [":exp4j"],
)

java_import(
    name = "exp4j",
    jars = ["lib/exp4j.jar"],
)

java_binary(
    name = "M",
    srcs = ["src/main/java/dev/thoq/Main.java"],
    javacopts = [
        "--source=21",
        "--target=21",
    ],
    main_class = "dev.thoq.Main",
    deps = [
        ":exp4j",
        ":lib",
    ],
)
