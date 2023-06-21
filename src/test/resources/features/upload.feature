Feature: Upload Feature

  Scenario Outline: Upload a file with accept terms of service
    Given User choose a file with file extension "<fileExt>" to upload
    When User submit file with "check" on Accept Terms Of Service checkbox
    Then User should see the message displays as "<message>"

    Examples:
      | fileExt | message                                   |
      | mp4     | 1 file has been successfully uploaded.    |
      | pdf     | 1 file has been successfully uploaded.    |
      | txt     | 1 file has been successfully uploaded.    |
