workflow "New workflow" {
  on = "push"
  resolves = ["Pages"]
}

action "GitHub Action for Maven" {
  uses = "LucaFeger/action-maven-cli@aed8a1fd96b459b9a0be4b42a5863843cc70724e"
  args = "clean test"
}

action "Filters for GitHub Actions" {
  uses = "actions/bin/filter@ec328c7554cbb19d9277fc671cf01ec7c661cd9a"
  needs = ["GitHub Action for Maven"]
  args = "branch master"
}

action "Pages" {
  uses = "maxheld83/ghpages@v0.1.2"
  needs = ["Filters for GitHub Actions"]
  secrets = ["GITHUB_TOKEN"]
  env = {
    BUILD_DIR = "docs"
  }
}
