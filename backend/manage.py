#!/usr/bin/env python
"""Django's command-line utility for administrative tasks."""
import os
import sys


def main():
    """Run administrative tasks."""
    os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'truffle.settings')
    try:
        from django.core.management import execute_from_command_line
    except ImportError as exc:
        raise ImportError(
            "Couldn't import Django. Are you sure it's installed and "
            "available on your PYTHONPATH environment variable? Did you "
            "forget to activate a virtual environment?"
        ) from exc
    parser = argparse.ArgumentParser()
    parser.add_argument('parameters', metavar='N', type=str, nargs='+', help='parameters')
    args = parser.parse_args()
    command = args.parameters
    command.insert(0,'manage.py')
    execute_from_command_line(command)



if __name__ == '__main__':
    main()
