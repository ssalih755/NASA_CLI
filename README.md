# 🚀 nasa-cli

A simple command-line interface (CLI) tool that interacts with the [NASA Open APIs](https://api.nasa.gov/) to retrieve **Near Earth Objects (NEOs)** based on a given date.  

---

## ✨ Features
- Fetches near earth object data from NASA’s API.
- Allows users to specify start date and end date (if not entered, default is 7 days after start date)  to see NEOs.
- Displays asteroid details such as:
  - Name
  - Estimated diameter
  - Potentially hazardous status
  - Approach date and velocity

---

## 📦 Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/nasa-cli.git
   cd nasa-cli
---

## 🔑 Getting a NASA API Key
NASA provides free API keys that you’ll need to use this tool.

- Visit the NASA API key signup page https://api.nasa.gov/
- Fill out the form with your name and email.
- Check your email for your personal API key.
- Copy the key and add it to your environment:
  ```bash
  export NASA_API_KEY=your_api_key_here

- Note: You can also use the default DEMO_KEY provided by NASA, but it has limited hourly/daily requests.

  
