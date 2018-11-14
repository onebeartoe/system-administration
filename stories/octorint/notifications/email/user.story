
As a system administrator,
I need configuration as code for Octoprint email notifications,
so that notifications have automated requisitioning and deployment.

Acceptance Criteria

The Octoprint notifications configuration for print start/stop events exists and
automation exists to append the 'events' block to ~/octoprint/config.yml and
the ~/.octoprint/config.yml is only updated if it does not contain the 'events:' block and
automation exists to revert the original ~/.octoprint/config.yml configuration and
the onebeartoe-email API is brought down for notifications and
the email credentials are securely stored on the filesystem and
