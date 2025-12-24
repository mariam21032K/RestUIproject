# 📚 How to Post Your Project to GitHub

Complete guide to push your TP333 project to GitHub.

---

## **STEP 1: Create a GitHub Account (If You Don't Have One)**

1. Go to https://github.com
2. Click **Sign up**
3. Enter your email, password, and username
4. Verify your email
5. Done! ✅

---

## **STEP 2: Create a New Repository on GitHub**

1. Log in to GitHub
2. Click the **"+"** icon in top-right corner
3. Click **"New repository"**
4. Fill in the form:
   - **Repository name:** `tp333` (or any name you like)
   - **Description:** `Person Management REST API with Java, Jersey, and MySQL`
   - **Visibility:** Select **Public** (so others can see it)
   - **Initialize with:** Leave empty (we'll push existing code)
5. Click **"Create repository"**

📌 **You'll see something like:**
```
https://github.com/YOUR_USERNAME/tp333.git
```
**Copy this URL - you'll need it!**

---

## **STEP 3: Initialize Git in Your Local Project**

Open PowerShell and navigate to your project:

```powershell
cd d:\fac\li3\tpSOA\tp333
```

**Initialize git repository:**
```powershell
git init
```

**Add all files:**
```powershell
git add .
```

**Create initial commit:**
```powershell
git commit -m "Initial commit: Person Management REST API"
```

You should see:
```
[main (root-commit) abc1234] Initial commit: Person Management REST API
 X files changed, Y insertions(+)
```

---

## **STEP 4: Connect to GitHub**

Replace `YOUR_USERNAME` with your actual GitHub username:

```powershell
git remote add origin https://github.com/YOUR_USERNAME/tp333.git
```

**Verify the connection:**
```powershell
git remote -v
```

Should show:
```
origin  https://github.com/YOUR_USERNAME/tp333.git (fetch)
origin  https://github.com/YOUR_USERNAME/tp333.git (push)
```

---

## **STEP 5: Push to GitHub**

**For the first time, use:**
```powershell
git branch -M main
git push -u origin main
```

**You'll be asked for credentials:**
- **Username:** Your GitHub username
- **Password:** Your GitHub personal access token (NOT your password!)

### 🔐 How to Create a Personal Access Token:

1. Go to GitHub Settings: https://github.com/settings/tokens
2. Click **"Generate new token"** → **"Generate new token (classic)"**
3. Fill in:
   - **Note:** `Local Git Push`
   - **Expiration:** 90 days (or whatever you prefer)
   - **Scopes:** Check ✅ `repo` (full control of private repositories)
4. Click **"Generate token"**
5. **Copy the token** (appears only once!)
6. Use this token as your password in PowerShell

---

## **STEP 6: Verify Upload**

1. Go to `https://github.com/YOUR_USERNAME/tp333`
2. You should see:
   - All your files/folders
   - Your README.md displayed
   - Code content visible
3. Done! ✅

---

## **🔄 Future Updates (After Making Changes)**

Whenever you make changes to your code:

```powershell
# Stage changes
git add .

# Commit with a message
git commit -m "Fix: Update database connection error handling"

# Push to GitHub
git push origin main
```

---

## **💡 Good Commit Messages**

Use clear, descriptive messages:

```powershell
# Good ✅
git commit -m "Fix: Add person now correctly saves name and age"
git commit -m "Feature: Add update endpoint"
git commit -m "Docs: Update README with API endpoints"

# Bad ❌
git commit -m "fixed stuff"
git commit -m "update"
git commit -m "asdf"
```

---

## **📋 Checklist**

- [ ] Created GitHub account
- [ ] Created new repository on GitHub
- [ ] Copied repository URL
- [ ] Ran `git init` in project folder
- [ ] Ran `git add .`
- [ ] Ran `git commit -m "..."`
- [ ] Ran `git remote add origin ...`
- [ ] Created personal access token
- [ ] Ran `git push -u origin main`
- [ ] Verified files appear on GitHub

---

## **🎯 Final GitHub URL**

Your repository will be at:
```
https://github.com/YOUR_USERNAME/tp333
```

You can now:
- ⭐ Share with others
- 🍴 Allow others to fork it
- 💬 Collaborate with team members
- 📚 Use as portfolio project

---

## **❓ Troubleshooting**

### Error: "fatal: not a git repository"
**Solution:**
```powershell
cd d:\fac\li3\tpSOA\tp333
git init
```

### Error: "Permission denied (publickey)"
**Solution:** Use HTTPS instead of SSH:
```powershell
git remote set-url origin https://github.com/YOUR_USERNAME/tp333.git
```

### Error: "Authentication failed"
**Solution:** 
1. Use personal access token, NOT your GitHub password
2. Generate new token at: https://github.com/settings/tokens

### Can't see your files on GitHub
**Solution:**
1. Wait 30 seconds for GitHub to refresh
2. Hard refresh browser: `Ctrl+Shift+R`
3. Check push was successful: `git log`

---

## **📖 Useful Git Commands**

```powershell
# Check status
git status

# View commit history
git log

# View recent changes
git diff

# Undo last commit (keep changes)
git reset --soft HEAD~1

# View remote URL
git remote -v

# Change remote URL
git remote set-url origin https://github.com/YOUR_USERNAME/tp333.git
```

---

**Happy coding! 🚀**
