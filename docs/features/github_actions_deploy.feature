Feature: GitHub Actions Automated Cloudflare Deployment
  As a developer
  I want a GitHub Actions workflow to build and deploy the web app
  So that pushing changes to the main branch automatically updates Cloudflare Pages

  Scenario: Continuous deployment on push to main
    Given a commit is pushed to the main branch
    When the GitHub Actions workflow "Build and Deploy WASM to Cloudflare Pages" triggers
    Then it compiles the Kotlin Wasm webApp distribution
    And deploys the static files to Cloudflare Pages project "sex-play"
