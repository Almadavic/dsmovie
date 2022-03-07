import {ReactComponent as GitHubIcon} from '/assets/img/github.svg';

function Navbar() {
    return (
        <header>
        <nav>
          <div>
            <h1>DSMovie</h1>
            <a href="https://github.com/Almadavic">
              <div>
                <GitHubIcon/>
                <p>/Almadavic</p>
              </div>
            </a>
          </div>
        </nav>
      </header>
    );
}

export default Navbar;