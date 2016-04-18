#!/bin/sh
#
# Copyright 2014-2016 CyberVision, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# SYNOPSIS
#     srcformat.sh [FILE]...
#
# DESCRIPTION
#     This script formats given source FILES according code style.


STYLE="--style=1tbs --indent=spaces=4 --pad-header --align-pointer=name --indent-preproc-block --indent-switches"

if [ -z "$@" ]; then echo "You must specify source files"; exit 1; fi

astyle $STYLE $@

