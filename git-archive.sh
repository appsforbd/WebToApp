#!/bin/bash
VERSION=`cat VERSION`
FOLDERNAME="backup"
CURRENTFOLDERNAME="${PWD##*/}"
FILENAME="archive_$(date +%d)_$(date +%m)_$(date +%Y)_$(date +%I)$(date +%M)$(date +%S)"

#git init       # on the root of the project folder
#git add .
#git commit -m "$CURRENTFOLDERNAME-$VERSION"
mkdir -p "$FOLDERNAME"
git archive HEAD --format=zip --prefix=$CURRENTFOLDERNAME/ > backup/$CURRENTFOLDERNAME-$VERSION.zip
echo Saved as $CURRENTFOLDERNAME-$VERSION.zip
echo Press Enter to Close this Window...
read