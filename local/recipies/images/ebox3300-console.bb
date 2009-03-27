#Angstrom bootstrap image

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

ANGSTROM_EXTRA_INSTALL ?= ""

DEPENDS = "task-base-extended"

IMAGE_INSTALL = "task-base-extended \
	    ${ANGSTROM_EXTRA_INSTALL}"

export IMAGE_BASENAME = "console-image"
IMAGE_LINGUAS = ""
BAD_RECOMMENDATIONS = "psplash-angstrom"

inherit image

