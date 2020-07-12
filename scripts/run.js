#!/usr/bin/node

const child_process = require("child_process");

const run_script = (command, args, callback) => {
  const child = child_process.spawn(command, args);

  let scriptOutput = "";

  child.stdout.setEncoding("utf8");
  child.stdout.on("data", (data) => {
    process.stdout.write(data);

    data = data.toString();
    scriptOutput += data;
  });

  child.stderr.setEncoding("utf8");
  child.stderr.on("data", (data) => {
    process.stdout.write(data);

    data = data.toString();
    scriptOutput += data;
  });

  child.on("close", (code) => {
    callback(scriptOutput, code);
  });
};

run_script("mvn", ["clean", "package"], (_, exitCode) => {
  console.log("\nProcess Finished.");
  console.log("exit code: " + exitCode);

  run_script(
    "java",
    [
      "-jar",
      "target/ignant-nono-chortle-1.0-SNAPSHOT.jar",
      "server",
      "config.yml",
    ],
    (_, code) => {
      console.log("\nProcess finished");
      console.log("exit code: " + code);
    }
  );
});
